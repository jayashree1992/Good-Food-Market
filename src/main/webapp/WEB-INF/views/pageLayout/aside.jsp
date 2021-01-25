  

  <h3 class="my-4">Categories</h3>
        <div class="list-group">
        
        <c:forEach items="${allCategories}" var="category">
        
          <a href="${localURL}/view/category/${category.id}/items" class="list-group-item" id="a_${category.name}">${category.name}</a>
         </c:forEach>
        </div> 