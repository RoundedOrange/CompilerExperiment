package AST_nodes;

import Tokens.*;

public class NumLiteral_ast_node extends AST_node
{
    public Token token;
    public NumLiteral_ast_node(Token token)
    {
        this.token = token;
    }
}
