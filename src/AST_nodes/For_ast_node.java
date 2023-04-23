package AST_nodes;

public class For_ast_node extends AST_node
{
    AST_node initialization;
    AST_node condition;
    AST_node increment;
    AST_node statement;
    public For_ast_node(AST_node initialization,AST_node condition,AST_node increment,AST_node statement)
    {
        this.initialization = initialization;
        this.condition = condition;
        this.increment = increment;
        this.statement = statement;
    }
}
