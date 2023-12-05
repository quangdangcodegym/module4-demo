#### Sử dụng spring data -jpa thì có kèm: spring-orm 5.3.5, spring-jdbc 5.3.5


    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
        <property name="url" value="jdbc:mysql://localhost:3306/c0623_banking_thymeleaf?characterEncoding=UTF-8" />
        <property name="username" value="root" />
        <property name="password" value="1234" />
    </bean>

    <!-- Entity Manager -->
    <bean id="entityManagerFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <property name="packagesToScan" value="com.cg.mvcproduct.model" />
        <property name="jpaVendorAdapter">
            <bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter" />
        </property>
        <property name="jpaProperties">
            <props>
                <prop key="hibernate.connection.useUnicode">true</prop>
                <prop key="hibernate.connection.charset">UTF-8</prop>
                <prop key="hibernate.format_sql">true</prop>
                <prop key="hibernate.show_sql">true</prop>
                <prop key="hibernate.hbm2ddl.auto">update</prop>
                <prop key="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</prop>
            </props>
        </property>
    </bean>

    <!-- Transaction Manager -->
    <bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
        <property name="entityManagerFactory" ref="entityManagerFactory" />
    </bean>



#### Để chứng minh Spring-data-jpa: JPARepository, tạo hàm kết hợp từ các từ khóa findAll, findByID
