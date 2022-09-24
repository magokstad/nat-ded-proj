#include <stdio.h>

int isOdd(int num) {
    return num & 1;
}

int isPair(int num) {
    return !(num & 1);
}

int main(void) {
    for (int i = 0; i < 40; i++)
    {
        printf("Is %d pair? %d\n", i, isPair(i));
    }
    return 0;
}