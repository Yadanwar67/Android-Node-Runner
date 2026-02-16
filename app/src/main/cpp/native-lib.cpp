#include <jni.h>
#include <vector>
#include <string>
#include <cstring>
#include <cstdlib>

#include "node.h"

// Starts Node.js from Java with given arguments
extern "C"
JNIEXPORT jint JNICALL
Java_com_example_nodebotdashboard_MainActivity_startNodeWithArguments(
        JNIEnv *env,
        jobject /* thiz */,
        jobjectArray arguments) {

    jsize argc = env->GetArrayLength(arguments);
    // Prepare vector to hold argument strings
std::vector<std::string> args;    args.reserve(argc);
    size_t total_bytes = 0;

    // Copy Java strings to C++ strings
    for (jsize i = 0; i < argc; i++) {
        jstring arg = (jstring) env->GetObjectArrayElement(arguments, i);
        const char *chars = env->GetStringUTFChars(arg, nullptr);
        args.emplace_back(chars);
        total_bytes += args.back().size() + 1;
        env->ReleaseStringUTFChars(arg, chars);
        env->DeleteLocalRef(arg);
    }

    // Allocate one contiguous buffer for argument strings
    char *buffer = static_cast<char *>(calloc(total_bytes, sizeof(char)));
    if (!buffer) {
        return -1;
    }

    // Build argv array pointers into the buffer
    std::vector<char *> argv(argc);
    char *cursor = buffer;
    for (jsize i = 0; i < argc; i++) {
        const std::string &s = args[i];
        std::memcpy(cursor, s.c_str(), s.size());
        argv[i] = cursor;
        cursor += s.size() + 1;
    }

    // Start Node.js (blocking call until Node exits)
    int exit_code = node::Start(static_cast<int>(argc), argv.data());

    free(buffer);
    return exit_code;
}
