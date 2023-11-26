package MatrixProcessing;

import java.util.Scanner;

public class Processing {
    public int[][] matrix;
    public int determinative = 0;

    public void printMatrix(int[][] matrix) {
        System.out.println("The result is:");

        for (int[] line : matrix) {
            for (int cell : line) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public void printMatrix(float[][] matrix) {
        System.out.println("The result is:");

        for (float[] line : matrix) {
            for (float cell : line) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++){
                matrix1[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return matrix1;
    }

    public float[][] multiplyMatrixConstant(float[][] matrix, float constant) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i][j] * constant;
            }
        }
        return matrix;
    }

    public float[][] multiplyMatrix(float[][] matrix1, float[][] matrix2) {

        float[][] multiplyMatrix = new float[matrix2.length][matrix2[0].length];
        float sum;

        for (int n = 0; n < matrix1.length; n++) {
            for (int i = 0; i < matrix2[0].length; i++) {
                sum = 0;
                for (int j = 0; j < matrix1.length; j++) {
                    float multiply = matrix1[n][j] * matrix2[j][i];
                    sum = sum + multiply;
                }
                multiplyMatrix[n][i] = sum;
            }
        }

        return multiplyMatrix;
    }

    public int[][] sideDiagonal(int[][] matrix1) {
        int[][] matrix = new int[matrix1.length][matrix1.length];

        for (int i = 0; i < matrix1.length; i++) {
            matrix[i] = matrix1[i].clone();
        }

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length - 1 - i; j++) {
                matrix1[matrix1.length - 1 - j][matrix1.length - 1 - i] = matrix[i][j];
                matrix1[i][j] = matrix[matrix1.length - 1 - j][matrix1.length - 1 - i];
            }
        }
        return matrix1;
    }

    public int[][] verticalLine(int[][] matrix1) {
        int[][] matrix = new int[matrix1.length][matrix1.length];

        for (int i = 0; i < matrix1.length; i++) {
            matrix[i] = matrix1[i].clone();
        }

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length / 2; j++) {
                matrix1[i][matrix1.length - 1 - j] = matrix[i][j];
                matrix1[i][j] = matrix[i][matrix1.length - 1 - j];
            }
        }
        return matrix1;
    }

    public int[][] horizontalLine(int[][] matrix1) {
        int[][] matrix = new int[matrix1.length][matrix1.length];

        for (int i = 0; i < matrix1.length; i++) {
            matrix[i] = matrix1[i].clone();
        }

        for (int i = 0; i < matrix1.length / 2; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                matrix1[i][j] = matrix[matrix1.length - 1 - i][j];
                matrix1[matrix1.length - 1 - i][j] = matrix[i][j];
            }
        }
        return matrix1;
    }

    public int[][] mainDiagonal(int[][] matrix1) {
        int[][] matrix = new int[matrix1.length][matrix1.length];

        for (int i = 0; i < matrix1.length; i++) {
            matrix[i] = matrix1[i].clone();
        }

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 1; j < matrix1[0].length; j = j + i + 1) {
                matrix1[i][j] = matrix[j][i];
                matrix1[j][i] = matrix[i][j];
            }
        }
        return matrix1;
    }

    public int[][] enterMatrix() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter matrix size: ");
        int userInputLine = in.nextInt();
        int userInputColumn = in.nextInt();

        int[][] matrix = new int[userInputLine][userInputColumn];

        System.out.println("Enter matrix:");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = in.nextInt();
            }
        }
        return matrix;
    }

    public float[][] enterMatrixFloat() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter matrix size: ");
        int userInputLine = in.nextInt();
        int userInputColumn = in.nextInt();

        float[][] matrix = new float[userInputLine][userInputColumn];

        System.out.println("Enter matrix:");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = in.nextInt();
            }
        }
        return matrix;
    }

    public void transpositionMenu(int input){
        switch (input){
            case 1:
                matrix = enterMatrix();
                matrix = mainDiagonal(matrix);
                printMatrix(matrix);
                break;

            case 2:
                matrix = enterMatrix();
                matrix = sideDiagonal(matrix);
                printMatrix(matrix);
                break;

            case 3:
                matrix = enterMatrix();
                matrix = verticalLine(matrix);
                printMatrix(matrix);
                break;

            case 4:
                matrix = enterMatrix();
                matrix = horizontalLine(matrix);
                printMatrix(matrix);
                break;

        }
    }

    public int determinativeMatrix2(int[][] matrix){
        int determinative;
        determinative = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        return determinative;
    }
    public static float determinativeMatrix2(float[][] matrix){
        float determinative;
        determinative = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        return determinative;
    }

    public int determinativeMatrix3(int[][] matrix) {
        int[][] determinativeMatrix = new int[3][5];
        int determinativePlus;
        int determinativeMinus;
        int determinativeSum = 0;
        int determinativeSum1 = 0;
        int determinative;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                determinativeMatrix[i][j] = matrix[i][j];
                if (j < 2) {
                    determinativeMatrix[i][j + 3] = matrix[i][j];
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            determinativePlus = 1;

            for (int j = 0; j < 3; j++) {
                determinativePlus = determinativePlus * determinativeMatrix[j][i + j];
            }
            determinativeSum = determinativeSum + determinativePlus;
        }

        for (int i = 0; i < 3; i++) {
            determinativeMinus = 1;
            for (int j = 2; j > -1; j--) {
                determinativeMinus = determinativeMinus * determinativeMatrix[2 - j][j + i];
            }
            determinativeSum1 = determinativeSum1 + determinativeMinus;
        }

        determinative = determinativeSum - determinativeSum1;

        return determinative;
    }
    public static float determinativeMatrix3(float[][] matrix) {
        float[][] determinativeMatrix = new float[3][5];
        float determinativePlus;
        float determinativeMinus;
        float determinativeSum = 0;
        float determinativeSum1 = 0;
        float determinative;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                determinativeMatrix[i][j] = matrix[i][j];
                if (j < 2) {
                    determinativeMatrix[i][j + 3] = matrix[i][j];
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            determinativePlus = 1;

            for (int j = 0; j < 3; j++) {
                determinativePlus = determinativePlus * determinativeMatrix[j][i + j];
            }
            determinativeSum = determinativeSum + determinativePlus;
        }

        for (int i = 0; i < 3; i++) {
            determinativeMinus = 1;
            for (int j = 2; j > -1; j--) {
                determinativeMinus = determinativeMinus * determinativeMatrix[2 - j][j + i];
            }
            determinativeSum1 = determinativeSum1 + determinativeMinus;
        }

        determinative = determinativeSum - determinativeSum1;

        return determinative;
    }


    public int determinativeMatrix4(int[][] matrix){
        int[][] matrix1 = new int[matrix.length - 1][matrix.length - 1];
        int[] matrixn = new int[matrix.length];
        int[] matrixa = new int[matrix.length];
        int[] multiplyMatrix = new int[matrix.length];
        int determinative = 0;

        int it;

        for (int n = 0; n < matrix.length; n++){
            it = 0;
            for (int i = 0; i < matrix.length; i++){
                if (i == n){
                    continue;
                }
                for (int j = 1; j < matrix.length; j++){
                    matrix1[it][j - 1] = matrix[i][j];
                }
                it++;
            }
            matrixn[n] = determinativeMatrix3(matrix1);
        }
        for (int i = 1; i < matrixn.length + 1; i++){
            if (i % 2 == 0){
                matrixn[i - 1] = matrixn[i - 1] * (-1);
            }
        }
        for (int i = 0; i < matrixn.length; i++){
            matrixa[i] = matrix[i][0];
        }
        for (int i = 0; i < matrixn.length; i++){
            multiplyMatrix[i] = matrixn[i] * matrixa[i];
            determinative = determinative + multiplyMatrix[i];
        }
        return determinative;
    }
    public int determinativeMatrix5(int[][] matrix){
        int[][] matrix1 = new int[matrix.length - 1][matrix.length - 1];
        int[] matrixn = new int[matrix.length];
        int[] matrixa = new int[matrix.length];
        int[] multiplyMatrix = new int[matrix.length];
        int determinative = 0;

        int it;

        for (int n = 0; n < matrix.length; n++){
            it = 0;
            for (int i = 0; i < matrix.length; i++){
                if (i == n){
                    continue;
                }
                for (int j = 1; j < matrix.length; j++){
                    matrix1[it][j - 1] = matrix[i][j];
                }
                it++;
            }
            matrixn[n] = determinativeMatrix4(matrix1);
        }
        for (int i = 1; i < matrixn.length + 1; i++){
            if (i % 2 == 0){
                matrixn[i - 1] = matrixn[i - 1] * (-1);
            }
        }
        for (int i = 0; i < matrixn.length; i++){
            matrixa[i] = matrix[i][0];
        }

        for (int i = 0; i < matrixn.length; i++){
            multiplyMatrix[i] = matrixn[i] * matrixa[i];
            determinative = determinative + multiplyMatrix[i];
        }
        return determinative;
    }

    private void determinativeIf (int[][] matrix){
        if (matrix.length  == 2){
            determinative = determinativeMatrix2(matrix);

        } else if (matrix.length  == 3) {
            determinative = determinativeMatrix3(matrix);

        }else if (matrix.length  == 4){
            determinative = determinativeMatrix4(matrix);

        }else if (matrix.length  == 5){
            determinative = determinativeMatrix5(matrix);
        } else {
            System.out.println("ждите обновлений");
        }
    }
    public static float[][] inverseMatrix3(float[][] matrix){
        float[][] matrix1 = new float[matrix.length - 1][matrix.length - 1];
        float[] matrixn = new float[matrix.length];
        float[][] matrixa = new float[matrix.length][matrix.length];
        float determinative;
        Processing processing = new Processing();

        int it;
        int jt;
        for (int a = 0; a < matrix.length; a++) {

            for (int n = 0; n < matrix.length; n++) {
                it = 0;
                for (int i = 0; i < matrix.length; i++) {
                    if (i == n) {
                        continue;
                    }
                    jt = 0;
                    for (int j = 0; j < matrix.length; j++) {
                        if (j == a){
                            continue;
                        }
                        matrix1[it][jt] = matrix[i][j];
                        jt++;
                    }
                    it++;
                }
                matrixn[n] = determinativeMatrix2(matrix1);
            }
            for (int at = 0; at < matrixn.length; at++){
                matrixa[a][at] = matrixn[at];
            }

            for (int i = 1; i < matrixn.length + 1; i++) {
                if (i % 2 == 0) {
                    matrixn[i - 1] = matrixn[i - 1] * (-1);
                }
            }

        }
        determinative = determinativeMatrix3(matrix);
        determinative = 1 / determinative;
        processing.multiplyMatrixConstant(matrixa, determinative);
        return matrixa;
    }

    public void menuMatrix(int userInput){
        Scanner in = new Scanner(System.in);
        switch(userInput){
            case 1:
                int[][] matrix1 = enterMatrix();
                int[][] matrix2 = enterMatrix();
                matrix = addMatrices(matrix1, matrix2);
                printMatrix(matrix);
                break;

            case 2:
                float[][] matrix = enterMatrixFloat();
                System.out.print("Enter constant: ");
                float constant = in.nextFloat();
                matrix = multiplyMatrixConstant(matrix, constant);
                printMatrix(matrix);
                break;

            case 3:
                float[][] matrix3 = enterMatrixFloat();
                float[][] matrix4 = enterMatrixFloat();
                float[][] multiplyMatrix = multiplyMatrix(matrix3, matrix4);
                printMatrix(multiplyMatrix);
                break;

            case 4:
                System.out.println("1. Main diagonal\n" +
                        "2. Side diagonal\n" +
                        "3. Vertical line\n" +
                        "4. Horizontal line");
                System.out.print("Your choice: ");
                int input = in.nextInt();
                transpositionMenu(input);
                break;

            case 5:
                this.matrix = enterMatrix();
                determinativeIf(this.matrix);
                System.out.println(determinative);
                break;

            case 6:
                float[][] matrix5 = enterMatrixFloat();
                matrix5 = inverseMatrix3(matrix5);
                printMatrix(matrix5);
                break;

            case 0:
                System.exit(0);
        }
    }
    public void matrixProgram(){
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("1. Add matrices\n" +
                    "2. Multiply matrix by a constant\n" +
                    "3. Multiply matrices\n" +
                    "4. Transpose matrix\n" +
                    "5. Calculate a determinant\n" +
                    "6. Inverse matrix\n" +
                    "0. Exit");

            int input = in.nextInt();
            menuMatrix(input);
        }
    }

}
