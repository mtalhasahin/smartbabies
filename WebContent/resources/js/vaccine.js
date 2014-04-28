var say = 1;

$
		.ajax(
				{
					url : "http://localhost:9080/smrtbaby/rest/member/activity/vaccine/1",
					dataType : "json"
				})
		.done(
				function(vaccines) {

					$
							.each(
									vaccines,
									function(i, item) {

										var myLi = document.createElement('li');

										myLi.setAttribute('id', 'task_' + say);

										myLi.innerHTML = "<div class='task-title' style='padding: 15 px;'><span class='task-title-sp'>"
												+ item.activityName
												+ "&nbsp;&nbsp;&nbsp;</span><span class='badge badge-sm label-success'> "
												+ item.activityDateDifference
												+ " Gün</span>&nbsp;&nbsp;&nbsp;<span class='badge badge-sm label-danger'> "
												+ item.activityRealizationDate
												+ "</span></div><hr style='border-top: dashed 1px; color: #AEB2B7;'> </hr>";

										document.getElementById('taskList')
												.appendChild(myLi);

										say++;
									})

				});