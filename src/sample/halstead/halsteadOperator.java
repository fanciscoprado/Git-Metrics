package sample.halstead;

//DataColected class: defines and identifies operators
public class halsteadOperator
{
    private boolean prefixFlag;
    private boolean suffixFlag;
    private String operatorName;

    public void setOperatorName(String name){
        this.operatorName = name;
    }

    public void setPrefixFlag(boolean bool){
        this.prefixFlag = bool;
    }

    public void setSuffixFlag(boolean bool){
        this.suffixFlag = bool;
    }

    public String getOperatorName(){
        return this.operatorName;
    }

    public boolean getPrefixFlag(){
        return this.prefixFlag;
    }

    public boolean getSuffixFlag(){
        return this.suffixFlag;
    }

    @Override
    public String toString(){
        return operatorName + ", " + prefixFlag + ", " + suffixFlag;
    }
}