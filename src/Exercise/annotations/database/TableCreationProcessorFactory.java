package Exercise.annotations.database;

import com.sun.mirror.apt.*;
import com.sun.mirror.declaration.*;
import static com.sun.mirror.util.DeclarationVisitor.*;
import static com.sun.mirror.util.DeclarationVisitors.NO_OP;
import static com.sun.mirror.util.DeclarationVisitors.getDeclarationScanner;

import com.sun.mirror.util.SimpleDeclarationVisitor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class TableCreationProcessorFactory
    implements AnnotationProcessorFactory {

    @Override
    public Collection<String> supportedOptions() {
        return Collections.emptySet();
    }

    @Override
    public Collection<String> supportedAnnotationTypes() {
        return Arrays.asList(
                "annotations.database.DBTable",
                "annotations.database.Constraints",
                "annotations.database.SQLString",
                "annotations.database.SQLInteger"
        );
    }

    @Override
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> set,
                                               AnnotationProcessorEnvironment annotationProcessorEnvironment) {

        return new TableCreationProcessor(annotationProcessorEnvironment);
    }

    private static class TableCreationProcessor
            implements AnnotationProcessor {
        private final AnnotationProcessorEnvironment env;
        private String sql = "";

        public TableCreationProcessor(AnnotationProcessorEnvironment env) {
            this.env = env;
        }

        @Override
        public void process() {
            for (TypeDeclaration typeDecl : env.getSpecifiedTypeDeclarations()) {
                typeDecl.accept(getDeclarationScanner(
                        new TableCreationVisitor(),NO_OP
                ));
                sql=sql.substring(0,sql.length()-1)+");";
                System.out.println("creation SQL is :\n"+sql);
                sql = "";
            }
        }
        private class TableCreationVisitor extends SimpleDeclarationVisitor {
            public void visitClassDeclaration(ClassDeclaration declaration) {
                DBTable dbTable = declaration.getAnnotation(DBTable.class);
                if (dbTable != null) {
                    sql += "CREATE TABLE ";
                    sql += (dbTable.name().length() < 1)
                            ? declaration.getSimpleName().toUpperCase()
                            : dbTable.name();
                    sql += " (";
                }
            }
            public void visitFieldDeclaration(FieldDeclaration d) {
                String columnName = "";
                if (d.getAnnotation(SQLInteger.class) != null) {
                    SQLInteger sInt = d.getAnnotation(SQLInteger.class);
                    if (sInt.name().length() < 1) {
                        columnName = d.getSimpleName().toUpperCase();
                    }else {
                        columnName = sInt.name();
                    }
                    sql+="\n    "+columnName+" INT"+
                    getConstraints(sInt.constrains())+".";
                }
                if (d.getAnnotation(SQLString.class) != null) {
                    SQLString sqlString = d.getAnnotation(SQLString.class);
                    if (sqlString.name().length() < 1) {
                        columnName = d.getSimpleName().toUpperCase();
                    }else {
                        columnName = sqlString.name();
                    }
                    sql += "\n   " + columnName + " VARCHAR(" + sqlString.value() +
                            ")" + getConstraints(sqlString.constrains()) + ".";
                }
            }

            private String getConstraints(Constraints con) {
                String constraints = "";
                if (!con.allowNull()) {
                    constraints += " NOT NULL";
                }
                if (!con.primaryKey()) {
                    constraints += " PRIMARY KEY";
                }
                if (con.unique()) {
                    constraints += " UNIQUE";
                }
                return constraints;
            }
        }
    }
}
