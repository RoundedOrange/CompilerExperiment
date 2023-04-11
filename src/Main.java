import Compiler.*;
public class Main {
    public static String[] strings = {
            "int main(){return 10;}",
            "int main() {return 7;}",
            "int main() {{} { {7;} }}",
            "int main(){42 + 10 -5;}",
            "int main(){42 + 10 --5;}",
            "int main(){42 + 10 -5; 8+7;}",
            "int main(){int temp = 7; int p = 9;}",
            "int main(){int temp = 7; int a = 19+1;}",
            "int main(){int temp=9, b = 7; }",
            "int main(){int b = 7; b; }",
            "int main(){int temp, b = 7; 9+b;}",
            "int main(float j, int k, float h){int temp, b = 11;;; int c = --9+b;}",
            "int main(){ true;}",
            "int main(){bool i=true;;bool k,s, j=false;}",
            "int main(float kk, int h){h =2; return h;}",
            "int main(float kk, int h){int i=81;}  float another() {21;}",
            "int main(){int h =2; return h;} ",
            "int main(){return 5+6;}",
            "int fun(int i, int j) {return i;} int main(){return fun(5, 1);} ",
            "int fun(int i, int j) {return j;} int main(){return fun(5, 7);} ",

            "int main(){return 0;/*block/*/}",//识别成功
            "int //annotation\nmain(){return 0;}",//识别成功
            "int main(){return 0;}//annotation",//识别成功
            //"int main(){return 0;/*annotation block}",//块注释报错
    };
    public static void test_lexer()
    {
        System.out.println("词法分析测试程序");
        for(int i=0;i<strings.length;i++)
        {
            System.out.println("-----No."+(i+1)+"-----");
            System.out.println("input:"+strings[i]);
            Lexer.analyse(strings[i]);
            System.out.print("output:[");
            for(int j = 0; j< Lexer.get_token_list().size(); j++)
            {
                System.out.print("\""+ Lexer.get_token_list().elementAt(j).lexeme+"\"");
                if(j != Lexer.get_token_list().size() - 1)
                    System.out.print(",");
            }
            System.out.println("]");
        }
        System.out.println("词法分析测试程序结束");
    }
    public static void test_parser()
    {
        System.out.println("语法分析测试程序");
        for(int i=0;i<strings.length;i++)
        {
            System.out.println("-----No."+(i+1)+"-----");
            System.out.println("input:"+strings[i]);
            Lexer.analyse(strings[i]);
            Parser.parse(Lexer.get_token_list());
            System.out.println();
            // 遍历AST
            System.out.println("success!");
        }
        System.out.println("语法分析测试程序结束");
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        test_lexer(); // 测试词法分析程序的代码
        test_parser(); // 测试语法分析程序的代码
    }
}
