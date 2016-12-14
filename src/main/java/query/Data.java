package query;


public class Data {
    private Result[] result;

    private String resultType;

    public Result[] getResult() {
        return result;
    }

    public void setResult(Result[] result) {
        this.result = result;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    @Override
    public String toString() {
        return "ClassPojo [result = " + result + ", resultType = " + resultType + "]";
    }
}