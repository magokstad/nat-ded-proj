; test.asm
; This is a comment
; Hello peeps

section .test:
    

section .data:
    message: db "Hello world!", 0xA
    message_length equ $-message

