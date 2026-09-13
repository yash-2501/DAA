#include <iostream>
using namespace std;

// Sequential Search
int sequentialSearch(int arr[], int n, int key)
{
    for (int i = 0; i < n; i++)
    {
        if (arr[i] == key)
            return i;
    }
    return -1;
}

// Binary Search
int binarySearch(int arr[], int n, int key)
{
    int low = 0, high = n - 1;

    while (low <= high)
    {
        int mid = (low + high) / 2;

        if (arr[mid] == key)
            return mid;
        else if (key < arr[mid])
            high = mid - 1;
        else
            low = mid + 1;
    }

    return -1;
}

int main()
{
    int n, key;

    cout << "Enter number of elements: ";
    cin >> n;

    int arr[n];

    cout << "Enter elements in sorted order: ";
    for (int i = 0; i < n; i++)
        cin >> arr[i];

    cout << "Enter element to search: ";
    cin >> key;

    int result1 = sequentialSearch(arr, n, key);
    int result2 = binarySearch(arr, n, key);

    if (result1 != -1)
        cout << "\nSequential Search: Element found at index "
             << result1 << endl;
    else
        cout << "\nSequential Search: Element not found" << endl;

    if (result2 != -1)
        cout << "Binary Search: Element found at index "
             << result2 << endl;
    else
        cout << "Binary Search: Element not found" << endl;

    return 0;
}