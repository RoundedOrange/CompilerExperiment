package AST_nodes;

import java.util.Vector;

public class VariableDeclaration_ast_node extends AST_node
{
    public Vector<AST_node> variable_declarations;
    public VariableDeclaration_ast_node(Vector<AST_node> variable_declarations)
    {
        this.variable_declarations = variable_declarations;
    }
}
