class Solve {
    int[] findTwoElement(int arr[], int n) {
        int[] result = new int[2];

        // Find the repeating element
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0) {
                result[0] = Math.abs(arr[i]); // Repeating element
            } else {
                arr[index] = -arr[index];
            }
        }

        // Find the missing element
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                result[1] = i + 1; // Missing element
                break;
            }
        }

        return result;
    }
}
