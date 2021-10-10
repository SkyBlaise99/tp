package seedu.address.model.product;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Product}'s {@code id} matches the id given.
 */
public class ProductContainsIdPredicate implements Predicate<Product> {
    //use a list for easier searching via streams
    private final List<String> id;

    public ProductContainsIdPredicate(List<String> id) {
        this.id = id;
    }

    @Override
    public boolean test(Product product) {
        return id.stream()
                .anyMatch(id -> {
                    Integer integerId = Integer.parseInt(id);
                    String stringOfId = integerId.toString();
                    return StringUtil.containsWordIgnoreCase(product.getId().toString(), stringOfId);
                });
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ProductContainsIdPredicate)// instanceof handles nulls
                && id.equals(((ProductContainsIdPredicate) other).id); // state check
    }
}
