<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New task</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/css/select2.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script>
    <script type="text/javascript" src="../js/newtask.js"></script>
    <link rel="stylesheet" href="../css/task-style.css" />
</head>
<body>
<div class="newtask">
    <form>
        <h2 class="main-text">New task</h2>
        <div class="form-group">
            <label class="text">Text <br>
                <input type="text" class="textbox" value="  "/>
            </label>
        </div>
        <div class="form-group">
            <label class="text">Due date <br>
            <input type="date" class="textbox"/>
            </label>
        </div>
        <div class="form-group">
            <label class="text">Status</label> <br>
            <select class="select">
                <option> </option>
                <option value="In progress">In progress</option>
                <option value="Pending">Pending</option>
                <option value="Completed">Completed</option>
                <option value="Incompleted">Incompleted</option>
            </select>
        </div>

        <div class="form-group">
            <label class="text-priority">Priority</label> <br>
            <select class="select">
                <option> </option>
                <option value="Minor">Minor</option>
                <option value="Critical">Critical</option>
                <option value="Normal">Normal</option>
            </select>
        </div>

        <div class="form-group">
            <label class="text">Tags</label> <br>
            <select class="select-mult" name="tags" id="tags" multiple="true">
                <option> </option>
                <option value="Daily routine">Daily routine</option>
                <option value="Home">Home</option>
                <option value="Work">Work</option>
                <option value="Reading">Reading</option>
            </select>
        </div>
        <div class="form-group">
            <button class="add" type="submit">Add</button>
            <button class="cancel" type="submit">Cancel</button>
        </div>
    </form>
</div>
</body>
</html>
