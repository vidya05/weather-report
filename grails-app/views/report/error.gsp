<!DOCTYPE html>
<html>
	<head>
		<title><g:if env="development">Grails Runtime Exception</g:if><g:else>Error</g:else></title>
		<meta name="layout" content="main">
		<g:if env="development"><link rel="stylesheet" href="${resource(dir: 'css', file: 'errors.css')}" type="text/css"></g:if>
	</head>
	<body>
		
		
			<ul class="errors">
				<li>An error has occurred</li>
			</ul>
                        <p>
                    <span class="label"> ${exception}</span>
    </p>
		
	</body>
</html>
