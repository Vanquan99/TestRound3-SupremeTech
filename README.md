# Android Internship 2022 - Test Round 3 - SupremeTech

[Please click this](https://coderbyte.com/sl-candidate?promo=supremetechcoltd-j377u:algorithm-assessment-1vp6bd6z2l) to start the Coderbyte Test.

[Round 1](https://github.com/Vanquan99/TestRound-SupremeTech)

[Round 2]()

### Kindly note down some important details related to this Test:

- The CoderByte Online Test is conducted in English.

- Do not cheat. We appreciate your own value more than the scores.

### Test Android Engineer (Intern/Fresher)
>Using the Kotlin language, have the function BitmapHoles(strArr: Array<String>): String 
Using the Kotlin language, have the function BitmapHoles(strArr: Array<String>): String 
take the array of strings stored in strArr, which will be a 2D matrix 
of 0 and 1's, and determine how many holes, or contiguous regions of 0's, 
exist in the matrix. A contiguous region is one where there is a 
@@ -30,9 +20,9 @@ Input:"01111", "01101", "00011", "11110"
Output:3
Input:"1011", "0010"
Output:2


# CODE
```
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
```



