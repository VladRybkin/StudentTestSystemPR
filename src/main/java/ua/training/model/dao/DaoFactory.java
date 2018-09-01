package ua.training.model.dao;

import ua.training.model.dao.impl.JDBCDaoFactory;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UserDao createUserDao();
    public abstract CourseDao createCourseDao();
    public abstract TestDao createTestDao();
    public abstract TestQuestionDao createTestQuestionDao();
    public abstract TestResultDao createTestResultDao();
    public abstract UserAnswerDao createUserAnswerDao();

    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    DaoFactory temp = new JDBCDaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}
