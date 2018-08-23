package net.euler;

public class _9_PythagoreanTriple {
    public static void main(String[] args) {
        
        int a, b, c;
        for (int m = 1 ; m < 20; m++) {
            for (int n = m + 1; n < 20; n++) {
                a = (n*n) - (m*m);
                b = 2*n*m;
                c = (n*n) + (m*m);
                
                int x = 2;
                int result = 0;
                do {
    //                System.out.println((a*x)+(b*x)+(c*x));
                    if ((a*x)+(b*x)+(c*x) == 1000) {
                        
                        System.out.println((a*x) + " " + (b*x) + " " + (c*x) + " = " + ((a*x)+(b*x)+(c*x)));
                        System.out.println((a*x) * (b*x) * (c*x));
                    }
                    x++;
                }while ((a*x)+(b*x)+(c*x) <= 1100);
                
            }
        }

        
        
        
    }
}
