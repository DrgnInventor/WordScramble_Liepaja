package burtuJuuklis;
// Java program for implementation of Bubble Sort 
class BubbleSort // edited to work with rezultati java, sorts both values and indexes at the same time
{ 
    void bubbleSort(int arr[], int arr2[]){ 
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] > arr[j+1]) 
                { 
                    // swap arr[j+1] and arr[j] 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp;
                    temp = arr2[j];
                    arr2[j] = arr2[j+1];
                    arr2[j+1] = temp; 
                } 
    } 
}