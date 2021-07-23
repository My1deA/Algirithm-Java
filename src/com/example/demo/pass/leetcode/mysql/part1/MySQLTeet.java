package com.example.demo.pass.leetcode.mysql.part1;

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
/*
SELECT DISTINCT l1.Num AS ConsecutiveNums  FROM Logs l1,  Logs l2, Logs l3
WHERE l1.Id = l2.Id - 1 AND l2.Id = l3.Id - 1 AND l1.Num = l2.Num AND l2.Num = l3.Num;
*/

    // 181 超过经理收入的员工
    // select a.name as Employee  from employee a ,employee b where a.ManagerId=b.Id and a.salary > b.salary

    //182 查找重复的电子邮箱
    // select email from person group by email having count(email) > 1

    //183 从不订购的客户
    //select name as 'Customers' from Customers c left join Orders o on  c.id=o.customerId where o.customerId is null

    // 184 部门中工资最高的员工
    /*  with temp as (select departmentId, max(salary) salary from employee group by departmentId)
       select d.name 'Department',e.name 'Employee', e.salary  from employee e left join department d on e.departmentId = d.id left join temp t on t.departmentId= d.id
      where e.salary = t.salary
     */
/*
SELECT Department.name AS 'Department',Employee.name AS 'Employee',Salary FROM Employee JOIN Department ON Employee.DepartmentId = Department.Id
WHERE (Employee.DepartmentId , Salary) IN (SELECT DepartmentId, MAX(Salary) FROM Employee GROUP BY DepartmentId)
 */

// 185  部门工资前三高的所有员工
/*
    select d.name 'Department',e.name 'Employee', e.salary from employee e left join department d on  e.departmentId = d.id
    where (select count(distinct salary) from employee e2 where e2.salary > e.salary and e2.departmentId = e1.departmentId) < 3
    and d.name is not null  order by d.name,e.salary desc

    # Write your MySQL query statement below
    select d.name 'Department',e.name 'Employee', e.salary from employee e inner join department d on  e.departmentId = d.id
    where (select count(distinct salary) from employee e2 where e2.salary > e.salary and e2.departmentId = e.departmentId) < 3
    order by d.name,e.salary desc
*/

//196 删除重复邮箱
/*
delete from Person
where Id not in
(
    SELECT p.id from  (SELECT min(id) as id FROM `Person` GROUP BY Email ) p
 )
*/

//197 上升温度
//select a.Id from  Weather as a join Weather as b on a.Temperature > b.Temperature and dateDiff(a.RecordDate,b.RecordDate) = 1

// 262 行程和用户
/*
 # Write your MySQL query statement below
SELECT
    request_at as 'Day', round(avg(Status!='completed'), 2) as 'Cancellation Rate'
FROM
    trips t JOIN users u1 ON (t.client_id = u1.users_id AND u1.banned = 'No')
    JOIN users u2 ON (t.driver_id = u2.users_id AND u2.banned = 'No')
WHERE
    request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY
    request_at
* */


    // 595 大的国家
    // select name,population,area from world where area >=3000000 or population>= 25000000

    // 596. 超过5名学生的课
    // select class from courses group by class having count(distinct student)>=5


// 601 体育馆的人流量
/*
select distinct a.* from stadium a,stadium b,stadium c
where a.people>=100 and b.people>=100 and c.people>=100
and (
     (a.id = b.id-1 and b.id = c.id -1) or
     (a.id = b.id-1 and a.id = c.id +1) or
     (a.id = b.id+1 and b.id = c.id +1)
) order by a.id
 */




}
