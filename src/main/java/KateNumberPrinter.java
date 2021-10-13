import java.util.Scanner;

public class KateNumberPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number");
        String s = scanner.nextLine();

        int n = 5; //ширина цифры
        int m = 6;
        int mid = n / 2 + 1;
        int midM = m/2+1;
        for (int k = 1; k <= m; k++) {
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case '0':
                        for (int j = 1; j <= n; j++) {
                            if ((j == 1 || j == n) || (k == 1 || k == m)) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        break;
                    case '1':
                        for (int j = 1; j <= n; j++) {
                            if (j == mid || k == m || (k + j == mid && j <= mid)) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        break;
                    case '2':
                        for (int j = 1; j <= n; j++) {
                            if ( k == m ||(j==mid&&k==1)||(j==mid+1&&k==1)||(j==n&&k==mid-1)|| (k + j == mid && j <= mid)||(k+j==m+1)) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        break;
                    case '3':
                        for (int j = 1; j <= n; j++) {
                            if ( (k==1)||(j==n&&k==mid-1)||(k+j==m+1&& k<midM)||(j==mid+1&&k==midM)||(j==mid-1&&k==midM-1)||(j==n&&k==midM+1)||(k==m&&j>1&&j<n)||j==1&&k==m-1) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        break;
                    case '4':
                        for (int j = 1; j <= n; j++) {
                            if (j == n || k == midM || (j == 1 && k <= midM)) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        break;
                    case '5':
                        for (int j = 1; j <= n; j++) {
                            if ( (k==1)||(j>=1&&j<n&&k==mid)||(j==1&&k==m-1)||((j==1&&k==midM-2))||
                                    (j==n&&k>mid&&k<m)||(k==m&&j>1&&j<n)) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        break;
                    case '8':
                        for (int j = 1; j <= n; j++) {
                            if ( (k==1&&j>1&&j<n)||(j==1&&k==mid-1)||(j==1&&k>mid&&k<m)||(k+j==m+1&& k<midM)||
                                    (j==mid-1&&k==midM-1)||(j==n&&k>mid&&k<m)||(k==m&&j>1&&j<n)) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }

                }
                System.out.print(" "); // Пробел между цифрами
                System.out.print(" "); // Пробел между цифрами
            }
            System.out.println(); // Перенос строки после отрисовки каждого ряда
        }
    }
}
