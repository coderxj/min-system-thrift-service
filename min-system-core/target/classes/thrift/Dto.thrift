namespace java com.acme.service.Dto
include 'Enums.thrift'

struct Expression {
    1:required Enums.OPERATE op;
    2:double num1;
    3:double num2;
}

struct ExpressionResult {
    1:double result;
}