package quiz;

import java.util.Arrays;

public class B12_Array2Quiz {
	
	public static void main(String[] args) {
		
		int [][] numArr = new int[][] {
			{1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1},
			{1, 1},
			{1, 1, 1, 1}
		};
		//1. numArr의 모든 값을 0 ~ 100 사이의 랜덤 정수로 바꿔보세요
		/* 해설
		for (int row = 0; row < numArr.length; row++) {
			for (int column = 0; column < numArr[row].length; column++) {
				numArr[row][column] = (int)(Math.random()*101);
			}
		}
		*/
		
		//2. 랜덤으로 바뀐 numArr의 모든 값을 출력하고 총합과 평균(소수점 둘재 자리)을 구해서 출력해보세요
		/* 해설
		int sum = 0;
		int count = 0;
		
		for (int row = 0; row < numArr.length; row++) {
			
			int len = numArr[row].length;
			count += len;
			
			for (int column = 0; column < numArr[row].length; column++) {
				System.out.print(numArr[row][column] + "\t");
				sum += numArr[row][column];
			}
			System.out.println();
		}
		
		System.out.printf("총합: %d, 평균: %.2f\n", sum, sum / (double)count );
		*/
		
		//3. numArr의 각 행의 합을 모두 구해서 출력해보세요
		/* 해설
		int[] rowSum = new int[numArr.length];
		
		for (int row = 0; row < numArr.length; row++) {
			for (int column = 0; column < numArr[row].length; column++) {
				rowSum[row] += numArr[row][column];
			}
		}
		*/
		
		//4. numArr의 각 열의 합을 모두 구해서 출력해보세요
		/* 해설
		int max_len = 0;
		
		for (int row = 0; row < numArr.length; row++) {
			max_len = Math.max(max_len, numArr[row].length);
		}
		
		int[] colSum = new int[max_len];
		
		for (int row = 0; row < numArr.length; row++) {
			for (int column = 0; column < numArr[row].length; column++) {
				colSum[column] += numArr[row][column];
			}
		}
		
		//배열을 편리하게 문자열로 변환하기
		System.out.println("행의 합: " + Arrays.toString(rowSum));
		System.out.println("열의 합: " + Arrays.toString(colSum));
		
		*/
		
		
		double avg = 0;
		int sum = 0;
		int number_count =0;
		int longest_row = 0;
		int row_sum[] = new int[numArr.length];
		

		for (int i = 0; i < numArr.length; i++) {
			for (int j = 0; j < numArr[i].length; j++) {
				numArr[i][j] = (int)(Math.random() * 101);
				row_sum[i] += numArr[i][j];
				sum += numArr[i][j];
				System.out.printf("numArr[%d][%d]의 값은 %d입니다\n", i, j, numArr[i][j]);
				number_count++;
				if(j + 1 > longest_row)
				{
					longest_row = j + 1;
				}
			}
		}
		avg = (double)sum/number_count;
		System.out.printf("numArr배열의 총합은 %d이고 평균은 %.2f입니다\n", sum ,avg );
		
		for(int i = 0; i < row_sum.length; i++) {
			System.out.printf("numArr배열의 %d행의 합은 %d 입니다\n",i +1,row_sum[i]);
		}
		
		int column_sum[] = new int[longest_row];
		for (int i = 0; i < longest_row; i++) {
			for (int j = 0; j < numArr.length; j++) {
				if(i>=numArr[j].length)
				{
					continue;
				}
				column_sum[i] += numArr[j][i];
			}
			System.out.printf("numArr배열의 %d열의 합은 %d 입니다\n",i +1,column_sum[i]);
		}
		

		
		
		
	}

}








