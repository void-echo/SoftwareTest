#include <bits/stdc++.h>
using namespace std;
bool is_prime(int a) {
    if ((a % 2) == 0) return false;
    for (int i = 3, e = sqrt(a); i <= e; i += 2) {
        if ((a % i) == 0) return false;
    }
    return true;
}
int main() {
    int m = 0;
    cin >> m;
    for (int k = m - 1, n = 0; k >= 2; --k)
        if (is_prime(k)) {
            cout << setw(6) << k;
            ++n;
            if (n >= 10) break;
        }
}