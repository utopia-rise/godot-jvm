#include "local_frame.h"

#include "jvm.h"

namespace jni {
    LocalFrame::LocalFrame(int p_capacity) {
        jni::Jvm::current_env().push_local_frame(p_capacity);
    }

    LocalFrame::~LocalFrame() {
        jni::Jvm::current_env().pop_local_frame();
    }

}// namespace jni