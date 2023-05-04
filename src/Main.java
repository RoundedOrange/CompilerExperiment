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
            "int main(){int c; c =9; return c-3;}",
            "int main(float kk, int h){int i=81;}  float another() {21;}",
            "int main(){int h =2; return h;} ",
            "int main(){return 5+6;}",
            "int fun(int i, int j) {return i;} int main(){return fun(5, 1);} ",
            "int fun(int i, int j) {return j;} int main(){return fun(5, 7);} ",
            " int main(){ int a[5] = { 11, 12, 13, 14,15}; return a[0]; }",
            "int i =1; int main(){ int sum = 0;  for (i=0;i<4; i=i+1) sum = sum +2*i; return sum; }",
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
            // 遍历AST
            System.out.println("success!");
        }
        System.out.println("语法分析测试程序结束");
    }
    public static void test_analyzer()
    {
        System.out.println("语义分析测试程序");
        for(int i=0;i< strings.length;i++)
        {
            System.out.println("-----No."+(i+1)+"-----");
            System.out.println("input:"+strings[i]);
            Lexer.analyse(strings[i]);
            Parser.parse(Lexer.get_token_list());
            Analyzer.analyze(Parser.get_entry_node());
        }
        System.out.println("语义分析测试程序结束");
    }
    public static void test_generator()
    {
        System.out.println("代码生成程序");
        for(int i=0;i< strings.length;i++)
        {
            System.out.println("-----No."+(i+1)+"-----");
            System.out.println("input:"+strings[i]);
            Lexer.analyse(strings[i]);
            Parser.parse(Lexer.get_token_list());
            Analyzer.analyze(Parser.get_entry_node());
            Generator.generate(Parser.get_entry_node());
        }
        System.out.println("代码生成程序结束");
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //test_lexer(); // 测试词法分析程序的代码
        //test_parser(); // 测试语法分析程序的代码
        //test_analyzer(); // 测试语义分析程序的代码
        test_generator();
    }
}
