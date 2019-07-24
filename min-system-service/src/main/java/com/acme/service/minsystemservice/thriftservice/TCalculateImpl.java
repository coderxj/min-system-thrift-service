package com.acme.service.minsystemservice.thriftservice;

import com.acme.service.Dto.Expression;
import com.acme.service.Dto.ExpressionResult;
import com.acme.service.Exception.MinSystemException;
import com.acme.service.service.TCalculate;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

/**
 * @author acme
 * @date 2019/7/24 11:41 PM
 */
@Service
public class TCalculateImpl implements TCalculate.Iface {
    @Override
    public ExpressionResult calculate(Expression exp) throws MinSystemException, TException {
        switch (exp.getOp()){
            case ADD: return new ExpressionResult(exp.getNum1() + exp.getNum2());
            case SUB: return new ExpressionResult(exp.getNum1() - exp.getNum2());
            case MUL: return new ExpressionResult(exp.getNum1() * exp.getNum2());
            case DIV: {
                if(exp.getNum2() == 0){
                    throw new MinSystemException(1000, "除数不能为0");
                }
                return new ExpressionResult(exp.getNum1() / exp.getNum2());
            }
        }
        return null;
    }
}
