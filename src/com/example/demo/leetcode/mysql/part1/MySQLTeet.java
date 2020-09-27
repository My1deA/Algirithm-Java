package com.example.demo.leetcode.mysql.part1;

public class MySQLTeet {
    //175 组合2个表
    //select FirstName, LastName, City, State from Person p left join Address a on p.PersonId=a.PersonId

    //176  第2高薪水
    // select distinct Salary as SecondHighestSalary from Employee order by Salary desc limit 1,1
    // select ifnull((select distinct Salary from Employee order by Salary desc limit 1,1),null) as SecondHighestSalary

//177 第N高薪水
/*
    CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
    BEGIN
    SET N := N-1;
    RETURN (
            SELECT salary FROM employee GROUP BY salary ORDER BY salary DESC LIMIT N, 1
    );
*/

    //178 分数排名
    // select score,(select count(distinct score) from scores t where t.score>=s.score) as 'Rank'  from scores s order by score desc

//180 连续出现的数字
//SELECT DISTINCT l1.Num AS ConsecutiveNums  FROM Logs l1,  Logs l2, Logs l3 WHERE l1.Id = l2.Id - 1 AND l2.Id = l3.Id - 1 AND l1.Num = l2.Num AND l2.Num = l3.Num;


    // 181 超过经理收入的员工
    // select a.name as Employee  from employee a ,employee b where a.ManagerId=b.Id and a.salary > b.salary

    //182 查找重复的电子邮箱
    // select email from person group by email having count(email) > 1

    //183 从不订购的客户
    //select name as 'Customers' from Customers c left join Orders o on  c.id=o.customerId where o.customerId is null

    // 184 部门中工资最高的员工
    //

// 185     

}
