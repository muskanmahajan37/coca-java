package com.phodal.coca.analysis.identifier;

import com.phodal.coca.java.JavaParser;
import com.phodal.coca.java.JavaParserBaseVisitor;

public class JavaIdentifierVisitor extends JavaParserBaseVisitor {

    private JIdentifier node;
    public JavaIdentifierVisitor(JIdentifier node){
        this.node = node;
    }

    @Override
    public Object visitPackageDeclaration(JavaParser.PackageDeclarationContext ctx) {
        node.setPkg(ctx.qualifiedName().getText());
        return super.visitPackageDeclaration(ctx);
    }


    @Override
    public Object visitClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
        node.setType("Class");
        node.setName(ctx.IDENTIFIER().getText());
        //XXX: implement interface
        return super.visitClassDeclaration(ctx);
    }

    @Override
    public Object visitMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
        JMethod method = new JMethod();
        //XXX: find the start position of {, not public
        method.setStartLine(ctx.start.getLine());
        method.setStartLinePosition(ctx.start.getCharPositionInLine());
        method.setStopLine(ctx.stop.getLine());
        method.setStopLinePosition(ctx.stop.getCharPositionInLine());
        method.setName(ctx.IDENTIFIER().getText());
        node.addMethod(method);
        return super.visitMethodDeclaration(ctx);
    }

    @Override
    public Object visitInterfaceDeclaration(JavaParser.InterfaceDeclarationContext ctx) {
        node.setType("Interface");
        node.setName(ctx.IDENTIFIER().getText());
        return super.visitInterfaceDeclaration(ctx);
    }

    @Override
    public Object visitInterfaceMethodDeclaration(JavaParser.InterfaceMethodDeclarationContext ctx) {
        JMethod method = new JMethod();
        //XXX: find the start position of {, not public
        method.setStartLine(ctx.start.getLine());
        method.setStartLinePosition(ctx.start.getCharPositionInLine());
        method.setStopLine(ctx.stop.getLine());
        method.setStopLinePosition(ctx.stop.getCharPositionInLine());
        method.setName(ctx.IDENTIFIER().getText());
        node.addMethod(method);
        return super.visitInterfaceMethodDeclaration(ctx);
    }

}
