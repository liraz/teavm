/*
 *  Copyright 2016 Alexey Andreev.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.teavm.ast;

import java.util.List;

public class RecursiveVisitor implements ExprVisitor, StatementVisitor {
    @Override
    public void visit(BinaryExpr expr) {
        expr.getFirstOperand().acceptVisitor(this);
        expr.getSecondOperand().acceptVisitor(this);
    }

    @Override
    public void visit(UnaryExpr expr) {
        expr.getOperand().acceptVisitor(this);
    }

    @Override
    public void visit(AssignmentStatement statement) {
        if (statement.getLeftValue() != null) {
            statement.getLeftValue().acceptVisitor(this);
        }
        statement.getRightValue().acceptVisitor(this);
    }

    @Override
    public void visit(ConditionalExpr expr) {
        expr.getCondition().acceptVisitor(this);
        expr.getConsequent().acceptVisitor(this);
        expr.getAlternative().acceptVisitor(this);
    }

    public void visit(List<Statement> statements) {
        for (Statement part : statements) {
            part.acceptVisitor(this);
        }
    }

    @Override
    public void visit(SequentialStatement statement) {
        visit(statement.getSequence());
    }

    @Override
    public void visit(ConstantExpr expr) {
    }

    @Override
    public void visit(ConditionalStatement statement) {
        statement.getCondition().acceptVisitor(this);
        visit(statement.getConsequent());
        visit(statement.getAlternative());
    }

    @Override
    public void visit(VariableExpr expr) {
    }

    @Override
    public void visit(SubscriptExpr expr) {
        expr.getArray().acceptVisitor(this);
        expr.getIndex().acceptVisitor(this);
    }

    @Override
    public void visit(SwitchStatement statement) {
        statement.getValue().acceptVisitor(this);
        for (SwitchClause clause : statement.getClauses()) {
            visit(clause.getBody());
        }
        visit(statement.getDefaultClause());
    }

    @Override
    public void visit(UnwrapArrayExpr expr) {
        expr.getArray().acceptVisitor(this);
    }

    @Override
    public void visit(WhileStatement statement) {
        if (statement.getCondition() != null) {
            statement.getCondition().acceptVisitor(this);
        }
        visit(statement.getBody());
    }

    @Override
    public void visit(InvocationExpr expr) {
        for (Expr argument : expr.getArguments()) {
            argument.acceptVisitor(this);
        }
    }

    @Override
    public void visit(BlockStatement statement) {
        visit(statement.getBody());
    }

    @Override
    public void visit(QualificationExpr expr) {
        if (expr.getQualified() != null) {
            expr.getQualified().acceptVisitor(this);
        }
    }

    @Override
    public void visit(BreakStatement statement) {
    }

    @Override
    public void visit(NewExpr expr) {
    }

    @Override
    public void visit(ContinueStatement statement) {
    }

    @Override
    public void visit(NewArrayExpr expr) {
        expr.getLength().acceptVisitor(this);
    }

    @Override
    public void visit(NewMultiArrayExpr expr) {
        for (Expr dimension : expr.getDimensions()) {
            dimension.acceptVisitor(this);
        }
    }

    @Override
    public void visit(ReturnStatement statement) {
        if (statement.getResult() != null) {
            statement.getResult().acceptVisitor(this);
        }
    }

    @Override
    public void visit(InstanceOfExpr expr) {
        expr.getExpr().acceptVisitor(this);
    }

    @Override
    public void visit(ThrowStatement statement) {
        statement.getException().acceptVisitor(this);
    }

    @Override
    public void visit(CastExpr expr) {
        expr.getValue().acceptVisitor(this);
    }

    @Override
    public void visit(InitClassStatement statement) {
    }

    @Override
    public void visit(PrimitiveCastExpr expr) {
        expr.getValue().acceptVisitor(this);
    }

    @Override
    public void visit(TryCatchStatement statement) {
        visit(statement.getProtectedBody());
        visit(statement.getHandler());
    }

    @Override
    public void visit(GotoPartStatement statement) {
    }

    @Override
    public void visit(MonitorEnterStatement statement) {
        statement.getObjectRef().acceptVisitor(this);
    }

    @Override
    public void visit(MonitorExitStatement statement) {
        statement.getObjectRef().acceptVisitor(this);
    }
}
