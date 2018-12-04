package sample;

//DataColected class: defines and identifies operators
public class halsteadOperator
{
    boolean prefixFlag;
    boolean suffixFlag;
    String operatorName;

    @Override
    public String toString(){
        return operatorName + ", " + prefixFlag + ", " + suffixFlag;
    }
}