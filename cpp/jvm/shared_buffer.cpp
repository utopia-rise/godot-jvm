#include "shared_buffer.h"

#ifdef DEBUG_ENABLED
SharedBuffer::SharedBuffer() : ptr(nullptr), position(0), capacity(0) {}

SharedBuffer::SharedBuffer(uint8_t* p_ptr, int p_position, int p_capacity) :
  ptr(p_ptr),
  position(p_position),
  capacity(p_capacity) {}
#else
SharedBuffer::SharedBuffer() : ptr(nullptr), position(0) {}

SharedBuffer::SharedBuffer(uint8_t* p_ptr, int p_position) : ptr(p_ptr), position(p_position) {}
#endif
