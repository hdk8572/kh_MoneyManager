<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
  <head>
    <title>Title of the document</title>
    <style>
      .tableFixHead {
        overflow-y: auto; /* make the table scrollable if height is more than 200 px  */
        height: 200px; /* gives an initial height of 200px to the table */
      }
      .tableFixHead thead th {
        position: sticky; /* make the table heads sticky */
        top: 0px; /* table head will be placed from the top of the table and sticks to it */
      }
      table {
        border-collapse: collapse; /* make the table borders collapse to each other */
        width: 100%;
      }
      th,
      td {
        padding: 8px 16px;
        border: 1px solid #ccc;
      }
      th {
        background: #eee;
      }
    </style>
  </head>
  <body>
    <div class="tableFixHead">
      <table>
        <thead>
          <tr>
            <th>Col 1</th>
            <th>Col 2</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1.1</td>
            <td>2.1</td>
          </tr>
          <tr>
            <td>1.2</td>
            <td>2.2</td>
          </tr>
          <tr>
            <td>1.3</td>
            <td>2.3</td>
          </tr>
          <tr>
            <td>1.4</td>
            <td>2.4</td>
          </tr>
          <tr>
            <td>1.5</td>
            <td>2.5</td>
          </tr>
          <tr>
            <td>1.6</td>
            <td>2.5</td>
          </tr>
          <tr>
            <td>1.7</td>
            <td>2.5</td>
          </tr>
          <tr>
            <td>1.8</td>
            <td>2.5</td>
          </tr>
        </tbody>
      </table>
    </div>
  </body>
</html>