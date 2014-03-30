[#ftl]

[#import "/spring.ftl" as spring /]

[#macro titleAndMenu]
<h1>You are logged in as ${authentication.name}</h1>
<a href="[@spring.url "/" /]">Main Page</a> | 
<a href="[@spring.url "/logout" /]">Logout</a>

<h2>Menu</h2>
<table>
	<tr>
		<td></td>
		<td>ROLE_USER</td>
		<td>ROLE_MANAGER</td>
		<td>ROLE_ADMIN</td>
	</tr>
	<tr>
		<td>Web Security</td>
		<td><a href="[@spring.url "/user" /]">User Page</a></td>
		<td><a href="[@spring.url "/manager" /]">Manager Page</a></td>
		<td><a href="[@spring.url "/admin" /]">Admin Page</a></td>
	</tr>
	<tr>
		<td>HandlerSecurityInterceptor</td>
		<td><a href="[@spring.url "/user2" /]">User Page</a></td>
		<td><a href="[@spring.url "/manager2" /]">Manager Page</a></td>
		<td><a href="[@spring.url "/admin2" /]">Admin Page</a></td>
	</tr>
	<tr>
		<td>Global Method Security</td>
		<td><a href="[@spring.url "/callUserService" /]">Call User Service</a></td>
		<td><a href="[@spring.url "/callManagerService" /]">Call Manager Service</a></td>
		<td><a href="[@spring.url "/callAdminService" /]">Call Admin Service</a></td>
	</tr>
</table>
<br/><br/>
[/#macro]
