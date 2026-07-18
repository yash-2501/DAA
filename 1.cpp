// Write a program to sort given elements of an array in ascending order using bubble sort. Analyze the time complexity for best, average and worst case.

/*
Time Complexity : 
    Best case is : O(n)
    Average Case : O(n^2)
    Worst Case : O(n^2)
*/

#include <iostream>
#include <vector>

using namespace std;

class BubbleSorter
{
private:
    vector<int> data;

public:
    BubbleSorter(const vector<int> &arr) : data(arr) {}

    void sortAscending()
    {
        int n = data.size();
        bool swapped;

        for (int i = 0; i < n - 1; i++)
        {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++)
            {
                if (data[j] > data[j + 1])
                {
                    swap(data[j], data[j + 1]);
                    swapped = true;
                }
            }

            // If no swapping occurs, array is already sorted
            if (!swapped)
                break;
        }
    }

    // Display Array
    void display() const
    {
        cout << "Sorted Array : ";

        for (const auto &value : data)
            cout << value << " ";

        cout << endl;
    }
};

int main()
{

    int n;

    cout << "Enter number of elements: ";
    cin >> n;

    if (n <= 0)
    {
        cout << "Invalid array size." << endl;
        return 0;
    }

    vector<int> arr(n);

    cout << "Enter " << n << " elements:" << endl;

    for (int i = 0; i < n; i++)
        cin >> arr[i];

    BubbleSorter sorter(arr);

    sorter.sortAscending();

    sorter.display();

    return 0;
}


