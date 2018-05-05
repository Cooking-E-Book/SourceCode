I. **Team name:**

- **MasterChef**  :)

II. **Team list:**

- Oxana Hristova ( **Oksana** )
- Pavel ( **lepaff** )
- Vladimir Georgiev ( **Godfatherr** )

III. URL of Git repository: https://github.com/Cooking-E-Book/SourceCode

IV. **Project purpose:**

Create an electronic cookbook with recipes for all kinds of dishes and beverages. This cookbook can be viewed and edited by several types   of users and possesses several characteristics all of which are described in more detail below:

A. **User** can be of several types and has different privileges dependent on user type:

1. **Visitor** - has no profile within the cookbook&#39;s platform and thus has no rights except to read recipes.
2. **Subscriber** - has a profile within the platform (featuring username, password, actual names, email address, and subscription plan) and has the right to read/ comment/ like/ dislike/ share recipes as well as like/ dislike/ reply to comments of other users. He/ she can also delete or edit his/ her own comments/ replies.
3. **Author** - has a profile and has all rights of **Subscriber** as well as the right to write recipes/ review recipes/ write summaries to his/ her own recipes.
4. **Administrator** - has a profile with the cookbook organization. He/ she has the rights of **Author** and more, but his/ her main role is to manage (administer) the cookbook. He/ she can edit or delete recipes/ comments/ replies/ summaries/ reviews of recipes. He/ she can view and edit user registry and update **Help** information (incl. **FAQs** and **ContactInformation** ).

Note: **Exception handlers** are defined in the user registration process (no duplicate usernames are allowed and no visitors can log into the cookbook platform).

B.   **Dish** – assigned to several categories (e.g., soups, salads, appetizers, beverages, desserts, etc.), can be linked to more than one **Recipe** , and can be rated by users. Based on the cooking method, a **Dish** can be also defined as **HeatTreatedDish** and **MechanicalTreatedDish**. The former is characterized by temperature and type of treatment (e.g., boiled, fried, baked, etc.) while the latter is characterized by treatment type (e.g., cut, blended, mixed, etc.). **Exception handlers** are defined for each dish category and are implemented in the process of treatment setting.

C. **Recipe** – has title, body, author, timestamp, auto id number, cooking **Step** , and **Ingredient**

D. **Step** – represents a given step (phase) in the entire cooking process (e.g., mix the eggs and sugar ). Its main properties are name (a keyword describing the step), cooking time , body, used **Utensils**.

E. **Ingredient** – represented by a name, quantity, measurement unit, energy count (kcal). It is categorized into **BulkIngredient** (of mineral or plant origin), **LiquidIngredient** (animal, mineral, or plant origin), **SolidIngredient** (animal, mushroom, or plant origin) depending on the origin/ source of the ingredient. Each of the possible origins (sources) are defined within the **Sourceable** interface. **Exception handlers** are defined for each ingredient type and are implemented in the process of origin (source) setting (e.g., vegetable oil cannot be of animal origin) and unit type setting (e.g., solid ingredients cannot be measured in ml / liters, etc.).

F.   **Message** – has an author and a timestamp, and is used for communication between users. Depending on its specific purpose in the communication process, it is assigned to several categories:
  1. **i.**** Comment** – used by laymen (amateur cooks) to express opinions about a given recipe and as replies to other comments. Each has an author, a timestamp, and a body. Other of its features include number of likes, dislikes, replies and an indicator whether it has been deleted. If deleted, no action can be performed upon it. Only its author or an administrator of the cookbook can delete/ edit it.
  2. **ii.**** Review **– used by** Author**(i.e., chefs) to express opinions about other authors&#39; recipes. They have same characteristics as of**Comment **but can be also rated based on the number of likes and dislikes posted by** Subscriber**.
  3. **iii.**** Summary **– used by** Author**(i.e., chefs) to summarize his/ her recipe and facilitates the decision-making process of readers when deciding whether to read the full recipe or continue browsing other recipes. Has same properties as**Review**, but different purpose.

  The cookbook also contains:

    - **Help** section with **ContactInformation** and **FAQ** list;

    - **UnitConverter** which helps users find the required quantities of each Ingredient in their preferred units (e.g., ounces, pounds, ml, liters, etc.). **Exception handlers** are defined and implemented when attempting to convert between units of incomparable type (e.g., kg to ml) or when attempting to use negative quantities in the conversion process.

    - **TemperatureConverter** facilitates easy conversion from Fahrenheit degrees to Celsius degrees and vice versa, depending on user&#39;s preference.
