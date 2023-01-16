<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>

<div class="container">
    <div>
        <a type="button" class="btn btn-primary btn-md" id="btn-add">Add Todo</a>
    </div>
    <br>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3>List of TODO's</h3>
        </div>
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th width="40%">Description</th>
                    <th width="40%">Target Date</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.description}</td>
                        <td>${dtf.format(todo.targetDate)}</td>
                        <td><a type="button" class="btn btn-success btn-update" data-id="${todo.id}">Update</a>
                            <a type="button" class="btn btn-warning btn-delete" data-id="${todo.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <label for="message"></label>
    <input id="message" value="${message}" hidden="hidden" />
    <%@ include file="modal-add.jsp"%>
</div>
<%@ include file="common/footer.jsp"%>