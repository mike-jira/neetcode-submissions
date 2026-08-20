class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        index = 0
        while index < len(arr):
            if index == (len(arr) - 1):
                arr[index] = -1
                break

            finder = index + 1
            grestest = arr[finder]

            while finder < len(arr):
                if arr[finder] > grestest:
                    grestest = arr[finder]
                finder += 1
            
            arr[index] = grestest
            index += 1

        return arr
