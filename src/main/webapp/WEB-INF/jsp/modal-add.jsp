<div class="modal fade" id="modal-update" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add Todo</h4>
            </div>
            <form:form method="post" modelAttribute="todo">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-primary">
                                <div class="panel-body">

                                        <form:hidden path="id" />
                                        <fieldset class="form-group">
                                            <form:label path="description">Description</form:label>
                                            <form:input path="description" type="text" class="form-control"
                                                        required="required" />
                                            <form:errors path="description" cssClass="text-warning" />
                                        </fieldset>

                                        <fieldset class="form-group">
                                            <form:label path="targetDate">Target Date</form:label>
                                            <form:input path="targetDate" type="date" class="form-control"
                                                        required="required" />
                                            <form:errors path="targetDate" cssClass="text-warning" />
                                        </fieldset>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-success">Save</button>
                </div>
            </form:form>
        </div>

    </div>
</div>