package com.acme.service.minsystemservice.service;

import com.acme.service.Exception.MinSystemException;
import org.springframework.stereotype.Service;

/**
 * @author acme
 * @date 2019/12/1 9:06 PM
 */
@Service
public class CalculateImpl implements ICalculate{
    @Override
    public double calculateAdd(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public double calculateSub(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public double calculateMul(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double calculateDiv(double num1, double num2) throws MinSystemException {
        if(num2 == 0) {
            throw new MinSystemException(1000, "除数不能为0");
        }
        return num1 / num2;
    }
}
