#ifndef GODOT_JVM_LOCAL_FRAME_H
#define GODOT_JVM_LOCAL_FRAME_H

namespace jni {

#define LOCAL_FRAME(size) jni::LocalFrame frame = jni::LocalFrame(size)

    /*
     * Set ups a local frame and pop it when the object is destroyed. The semantics
     * are similar to:
     *
     * try {
     *  env->push_local_frame(capacity);
     * } finally {
     *  env->pop_local_frame();
     * }
     *
     */
    class LocalFrame {
    public:
        LocalFrame(int p_capacity);
        ~LocalFrame();
    };

}// namespace jni

#endif// GODOT_JVM_LOCAL_FRAME_H
