#include <windows.h>
#include <tchar.h>
#include <strsafe.h>

#define BUF_SIZE 255

DWORD WINAPI MyThreadFunction(LPVOID lpParam);

int _tmain(){
    DWORD   dwThreadId;
    HANDLE  hThread;

    hThread = CreateThread(NULL, 0, MyThreadFunction, NULL, 0, &dwThreadId);

    if (hThread == NULL){
        ExitProcess(1);
    }

    WaitForSingleObject(hThread, INFINITE);
    CloseHandle(hThread);

    return 0;
}

DWORD WINAPI MyThreadFunction(LPVOID lpParam){
    HANDLE hStdout;

    hStdout = GetStdHandle(STD_OUTPUT_HANDLE);
    if(hStdout == INVALID_HANDLE_VALUE){
        return 1;
    }

    WriteConsole(hStdout, "Hello Ukraine!\n", 15, NULL, NULL);

    return 0;
}
