


/*
Using the Kotlin language, have the function BitmapHoles(strArr: Array<String>): String 
take the array of strings stored in strArr, which will be a 2D matrix 
of 0 and 1's, and determine how many holes, or contiguous regions of 0's, 
exist in the matrix. A contiguous region is one where there is a 
connected group of 0's going in one or more of four directions: up, 
down, left, or right. For example: if strArr is 
["10111", "10101", "11101", "11111"], then this looks like the following matrix: 
1 0 1 1 1
1 0 1 0 1
1 1 1 0 1
1 1 1 1 1 
For the input above, your program should return 2 because
there are two separate contiguous regions of 0's, which create 
"holes" in the matrix. You can assume the input will not be empty. 
Input:"01111", "01101", "00011", "11110"
Output:3
Input:"1011", "0010"
Output:2
*/


import com.sun.javaws.exceptions.InvalidArgumentException
import kotlin.collections.HashSet


fun BitmapHoles(strArr: Array<String>): String {
    if(strArr.isEmpty())
        return "0" // optional

    val rowSize = strArr[0].length
    var groupsCount = 0
    var index = 0
    val roots = HashSet<Pair<Int, Int>>()

    while(index < rowSize) {
        var previousValue: Char? = null
        for((rowNum, row) in strArr.withIndex()) {
            if(row.length != rowSize)
                throw InvalidArgumentException(arrayOf("invalid matrix format")) // optional

            val isRoot = row[index] == '0' && previousValue != '0' && (index == 0 ||
                    row[index-1] != '0')
            val isCorrection = row[index] == '0' && previousValue == '0' && index > 0 && 
                row[index-1] == '0' && roots.contains(index-1 to rowNum)

            if(isRoot) {
                groupsCount++
                roots.add(index to rowNum)
            }
            else if(isCorrection) {
                groupsCount--
                roots.remove(index-1 to rowNum)
            }
            
            previousValue = row[index]
        }
        index++
    }

    return groupsCount.toString()
}



