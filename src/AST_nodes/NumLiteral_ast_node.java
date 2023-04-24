package AST_nodes;

import Tokens.*;
import Visitors.Visitor;

public class NumLiteral_ast_node extends AST_node
{
    public Token token;
    public NumLiteral_ast_node(Token token)
    {
        this.token = token;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
