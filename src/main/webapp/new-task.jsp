<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New task</title>
    <link rel="stylesheet" href="task-style.css" />
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
            <label class="text">Status <br>
            <input type="text" class="textbox" id="textStatus" readonly="readonly"/>
            </label>
        </div>
        <div class="form-group">
            <label class="text">Tags <br>
            <input type="text" class="textbox" id="textTag" readonly="readonly"/>
            </label>
        </div>
        <div class="form-group">
            <label class="text">Priority <br>
            <input type="text" class="textbox" id="textPriority" readonly="readonly"/>
            </label>
        </div>
        <div class="form-group">
            <button class="add" type="submit">Add</button>
            <button class="cancel" type="submit">Cancel</button>
        </div>

        <div class="label-form"><label>Status select box single choice <br>
        <div class="checkbox-status">
            <div class="div-label-status"><label class="label-checkbox">In progress
                <input type="radio" name="status" onclick="selectStatus(this.value)" value="  In progress"/>
            </label><br></div>
            <div class="div-label-status"><label class="label-checkbox">Pending
                <input type="radio" name="status" onclick="selectStatus(this.value)" value="  Pending"/>
            </label><br></div>
            <div class="div-label-status"><label class="label-checkbox">Completed
                <input type="radio" name="status" onclick="selectStatus(this.value)" value="  Completed"/>
            </label><br></div>
            <div class="div-label-status"><label class="label-checkbox">Incompleted
                <input type="radio" name="status" onclick="selectStatus(this.value)" value="  Incompleted"/>
            </label><br></div>
        </div>
        </label></div>
        <script>
            function selectStatus(status) {
                document.getElementById("textStatus").value = status;
            }
        </script>

        <div class="label-form-tags"><label>Tags select box multiple choice <br>
            <div class="tags">
                <div class="label-tags"><label class="label-checkbox">Daily routine
                    <input type="checkbox" name="tag" onclick="selectTag()" value="  Daily routine"/>
                </label></div>
                <div class="label-tags"><label class="label-checkbox">Home
                    <input type="checkbox" name="tag" onclick="selectTag()" value="  Home"/>
                </label></div>
                <div class="label-tags"><label class="label-checkbox">Work
                    <input type="checkbox" name="tag" onclick="selectTag()" value="  Work"/>
                </label></div>
                <div class="label-tags"><label class="label-checkbox">Reading
                    <input type="checkbox" name="tag" onclick="selectTag()" value="  Reading"/>
                </label></div>
            </div>
        </label></div>
        <script>
            function selectTag() {
                var groupName = document.getElementsByName('tag');
                var text = document.getElementById("textTag");
                text.value=''
                for (let i = 0; i < groupName.length; i++) {
                    if (groupName[i].checked) {
                        console.log(groupName[i].value);
                        text.value = text.value + groupName[i].value
                    }
                }
            }
        </script>

        <div class="label-form-priority"><label>Priority select box single choice <br>
            <div class="checkbox-priority">
                <div class="div-label"><label class="label-checkbox">Minor
                    <input type="radio" name="priority" onclick="selectPriority(this.value)" value="  Minor"/>
                </label><br></div>
                <div class="div-label"><label class="label-checkbox">Critical
                    <input type="radio" name="priority" onclick="selectPriority(this.value)" value="  Critical"/>
                </label><br></div>
                <div class="div-label"><label class="label-checkbox">Normal
                    <input type="radio" name="priority" onclick="selectPriority(this.value)" value="  Normal"/>
                </label><br></div>
            </div>
        </label></div>
        <script>
            function selectPriority(priority) {
                document.getElementById("textPriority").value = priority;
            }
        </script>


    </form>
</div>
</body>
</html>
