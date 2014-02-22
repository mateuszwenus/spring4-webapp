[#ftl]

[#import "/spring.ftl" as spring /]

[#macro titleAndMenu]
<h1>You are logged in as ${authentication.name}</h1>
<a href="[@spring.url "/" /]">Main Page</a> | 
<a href="[@spring.url "/user" /]">User</a> | 
<a href="[@spring.url "/manager" /]">Manager</a> |
<a href="[@spring.url "/admin" /]">Admin</a> |
<a href="[@spring.url "/logout" /]">Logout</a>
<br/><br/>
[/#macro]
