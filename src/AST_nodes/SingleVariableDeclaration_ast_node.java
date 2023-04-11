package AST_nodes;

import java.util.Vector;

/*单变量声明对应节点*/
public class SingleVariableDeclaration_ast_node extends AST_node
{
    public AST_node type;
    public AST_node variable;
    Vector<AST_node> inits;
    public SingleVariableDeclaration_ast_node(AST_node type,AST_node variable,Vector<AST_node> inits)
    {
        this.type = type;
        this.variable = variable;
        this.inits = inits;
    }
}
