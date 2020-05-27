class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val startPixel = image[sr][sc]
        setupImage(image, sr, sc, newColor, startPixel)
        return image
    }

    private tailrec fun setupImage(image: Array<IntArray>, row: Int, col: Int, newColor: Int, startPixel: Int) {
        if (row < 0 || col < 0 || row > image.lastIndex || col > image[0].lastIndex) return
        if (image[row][col] != startPixel || image[row][col] == newColor) return

        image[row][col] = newColor
        setupImage(image, row, col - 1, newColor, startPixel) // left
        setupImage(image, row - 1, col, newColor, startPixel) // top
        setupImage(image, row, col + 1, newColor, startPixel)// right
        setupImage(image, row + 1, col, newColor, startPixel)// bottom
    }
}
